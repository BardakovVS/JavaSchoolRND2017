//
//
//import static org.mockito.Mockito.*;
//import static org.junit.Assert.*;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mock;
//import org.mockito.runners.MockitoJUnitRunner;
//import java.util.List;
//
//
//@RunWith(MockitoJUnitRunner.class)
//public class MyIteratorTest {
//
//    MyIterator<String> myIterator;
//
//    @Mock
//    List<String> mockList;
//
//    @Test
//    public void testHasNextEmptyList() {
//
//        when(mockList.get(anyInt())).thenThrow(new IndexOutOfBoundsException());
//        when(mockList.size()).thenReturn(0);
//
//        myIterator = new MyIterator<>(mockList);
//        assertFalse(myIterator.hasNext());
//    }
//
//    @Test
//    public void testHasNextNotEmptyList() {
//
//        when(mockList.get(anyInt())).thenReturn("1");
//        when(mockList.size()).thenReturn(1);
//
//        myIterator = new MyIterator<>(mockList);
//        assertTrue(myIterator.hasNext());
//    }
//
//    @Test
//    public void testNextEmptyList() {
//
//        when(mockList.get(anyInt())).thenThrow(new IndexOutOfBoundsException());
//        when(mockList.size()).thenReturn(0);
//
//        myIterator = new MyIterator<>(mockList);
//        assertNull(myIterator.next());
//    }
//
//    @Test
//    public void testNextNotEmptyList() {
//
//        when(mockList.get(anyInt())).thenReturn("1");
//        when(mockList.size()).thenReturn(1);
//
//        myIterator = new MyIterator<>(mockList);
//        assertNotNull(myIterator.next());
//    }
//
//    @Test
//    public void testRemoveNotEmptyList() {
//
//        when(mockList.get(anyInt())).thenReturn("1");
//        when(mockList.size()).thenReturn(1, 1, 0);
//
//        myIterator = new MyIterator<>(mockList);
////        int size1 = mockList.size();
////        int size2 = mockList.size();
//        assertEquals(1,mockList.size());
//        myIterator.remove();
//        assertEquals(0, mockList.size());
//    }
//
//    @Test(expected =  IndexOutOfBoundsException.class)
//    public void testRemoveExceptionEmptyList() {
//
//        when(mockList.get(anyInt())).thenThrow(new IndexOutOfBoundsException());
//        when(mockList.size()).thenReturn(0);
//        when(mockList.remove(anyInt())).thenThrow(new IndexOutOfBoundsException());
//
//        myIterator = new MyIterator<>(mockList);
//        myIterator.remove();
//    }
//}
