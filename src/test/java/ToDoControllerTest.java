import com.dj.todolist.controller.ToDoController;
import com.dj.todolist.domain.entity.ToDoItem;
import com.dj.todolist.domain.repository.Repository;
import com.dj.todolist.utilities.InputUtilities;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

// extendwith is a JUnit 5 annotation for extending the behaviour of the JUnit runner
// mockitoExtension is the Mockito JUnit runner extension
@ExtendWith(value = MockitoExtension.class)
public class ToDoControllerTest {

    // In a Unit Test, we don't care about the dependencies of a method
    // - we only care what the method being tested is doing
    // - we mock the dependencies and specify what we'd like returned

    @Mock
    private Repository<ToDoItem, Long> todoRepo;
    //annotate mocked items with @mock
    // with mocking, we don't need to create implementations of anything. we can just
        // specify what we want returned from the methods of a dependency

    //this injects the required dependencies into the fields on controller
    // - our mock dependencies
    @InjectMocks
    private ToDoController controller;

    // External behaviours of ToDoController.create()
    // we look at the java file
    //

    @Test
    public void createTest(){

        //Mockedstatic comes from the Mockito inline dependency
        // - allows us to test static methods
        // - Mockito.mockStatic takes the class whose static methods we want to mock
        try (MockedStatic<InputUtilities> utils = Mockito.mockStatic(InputUtilities.class)) {

            //now we prepare the test data
            ToDoItem expected = new ToDoItem(1,
                                             "Finish App",
                                              LocalDate.of(2022,07,15));
            ToDoItem toSave = new ToDoItem(1,
                                           "Finish App",
                                            LocalDate.of(2022,07,15));
            ToDoItem toReturn = new ToDoItem(1,
                                             "Finish App",
                                             LocalDate.of(2022,07,15));

            //then specify what the mock object methods (or static methods) should return
            // Format - Mockito.when(MockObject.method()).thenReturn(value);
            Mockito.when(InputUtilities.getString("Name: ")).thenReturn(toSave.getName());
            Mockito.when(InputUtilities.getString("Due Date (yyyy-mm-dd): ")).thenReturn(toSave.getName());
            Mockito.when(todoRepo.save(toSave)).thenReturn(true);

            ToDoItem actual = controller.createForTest();

            Assertions.assertEquals(expected, actual);
            utils.verify(() -> InputUtilities.getString("Name: ")); //verifying a static object
            utils.verify(() -> InputUtilities.getString("Due Date (yyyy-mm-dd): "));
            utils.verifyNoMoreInteractions();
            Mockito.verify(todoRepo).save(toSave); //verifying the save method
                                            // on the mocked repo object


        }

    }


}
