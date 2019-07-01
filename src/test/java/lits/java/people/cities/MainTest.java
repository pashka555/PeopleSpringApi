package lits.java.people.cities;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
public class MainTest {
    @Test(expected = RuntimeException.class)
    public void test() {
        final int i = sumthings(1, 2) / 0;
    }

    public int sumthings(int n1, int n2) {
        return n1+n2;
    }
}
