package homeWork.homeWork17.goodCode;

import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class SalaryHtmlReportNotifier {

    private Connection connection;

    public SalaryHtmlReportNotifier(Connection databaseConnection) {
        this.connection = databaseConnection;
    }

    private ResultSet querySQL(String departmentId, LocalDate dateFrom, LocalDate dateTo) {
        ResultSet results = null;
        try {
            // подготовить запрос SQL
            PreparedStatement ps = connection.prepareStatement(
                            "select emp.id as emp_id, " +
                                "emp.name as amp_name, " +
                                "sum(salary) as salary " +
                                "from employee emp left join salary_payments sp on emp.id = sp.employee_id " +
                                "where emp.department_id = ? " +
                                "and sp.date >= ? " +
                                "and sp.date <= ? " +
                                "group by emp.id, emp.name");
            // ввести параметры в SQL
            ps.setString(0, departmentId);
            ps.setDate(1, new java.sql.Date(dateFrom.toEpochDay()));
            ps.setDate(2, new java.sql.Date(dateTo.toEpochDay()));
            results = ps.executeQuery();// выполнить запрос и получить результаты
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return results;
    }

    private StringBuilder generateHtml(ResultSet results) {
        // create a StringBuilder holding a resulting html
        StringBuilder resultingHtml = new StringBuilder();
        resultingHtml.append("<html><body><table><tr><td>Employee</td><td>Salary</td></tr>");
        double totals = 0;
        try {
            while (results.next()) {
                // обрабатывать каждую строку результатов запроса
                resultingHtml.append("<tr>"); // add row start tag
                resultingHtml.append("<td>").append(results.getString("emp_name")).append("</td>"); // appending employee name
                resultingHtml.append("<td>").append(results.getDouble("salary")).append("</td>"); // appending employee salary for period
                resultingHtml.append("</tr>"); // add row end tag
                totals += results.getDouble("salary"); // add salary to totals
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        resultingHtml.append("<tr><td>Total</td><td>").append(totals).append("</td></tr>");
        resultingHtml.append("</table></body></html>");
        return resultingHtml;
    }

    public void sendSalaryReport(String departmentId, LocalDate dateFrom, LocalDate dateTo, String recipients) {
        ResultSet resultsQuery = querySQL(departmentId, dateFrom,  dateTo);
        StringBuilder resultingHtml = generateHtml(resultsQuery);
        // Теперь, когда отчет построен, мы должны отправить его в список получателей
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("mail.google.com");// мы собираемся использовать Google mail для отправки этого сообщения
        MimeMessage message = mailSender.createMimeMessage();// construct the message
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setTo(recipients);
        helper.setText(resultingHtml.toString(), true);//последний параметр 'True', говорит, что это HTML-формате
        helper.setSubject("Monthly department salary report");
        try {
            mailSender.send(message);// send the message
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}