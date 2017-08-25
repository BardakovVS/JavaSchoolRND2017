package homeWork.homeWork2;

public abstract class ClientImpl {
    private Long id;

    public abstract String getFullName();

    public abstract void Print();

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
}

