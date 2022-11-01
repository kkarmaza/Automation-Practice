import org.junit.jupiter.api.*;

public class JUnit5Annotations {
    @BeforeAll
    static void BeforeAll()
    {
        System.out.println("BeforeAll");
    }

    @BeforeEach
    void BeforeEach()
    {
        System.out.println("BeforeEach");
    }

    @AfterAll
    static void AfterAll()
    {
        System.out.println("AfterAll");
    }

    @AfterEach
    void AfterEach()
    {
        System.out.println("AfterEach");
    }


}
