package UnitTest;

import es.ulpgc.Calculator.StringCalculator;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Calculator_ {
    StringCalculator calc;
    @Before
    public void setUp() {
        calc = new StringCalculator();
    }

    @Test
    public void empty_string_should_return_zero() throws Exception {
        assertThat(calc.calculate("")).isZero();
    }

    @Test
    public void single_number_should_return_the_value() throws Exception {
        assertThat(calc.calculate("3")).isEqualTo(3);
    }

    @Test
    public void two_numbers_with_comma_should_return_the_sum() throws Exception {
        assertThat(calc.calculate("1,2")).isEqualTo(3);
    }

    @Test
    public void two_numbers_with_newline_should_return_the_sum() throws Exception {
        assertThat(calc.calculate("1\n2")).isEqualTo(3);
    }
    @Test
    public void three_numbers_with_newline_should_return_the_sum() throws Exception {
        assertThat(calc.calculate("1\n2\n3")).isEqualTo(6);
    }
    @Test
    public void three_numbers_with_comma_should_return_the_sum() throws Exception {
        assertThat(calc.calculate("1,2,3")).isEqualTo(6);
    }

    @Test(expected = Exception.class)
    public void negative_number_throw_a_exception() throws Exception {
        assertThat(calc.calculate("-1"));
    }
    @Test
    public void large_number_throw_a_exception() throws Exception {
        assertThat(calc.calculate("1001,1,2")).isEqualTo(3);
    }
    @Test
    public void large_number_with_newline_throw_a_exception() throws Exception {
        assertThat(calc.calculate("1001\n1\n2")).isEqualTo(3);
    }

}
