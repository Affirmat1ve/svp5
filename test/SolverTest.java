
import org.junit.*;
import static java.lang.Math.pow;
import static java.lang.StrictMath.sqrt;


public class SolverTest {
    @Test
    public void testCalculateRoots() {
        double a, b, c, x;
        a = 0;
        b = 0;
        c = 1;
        Assert.assertEquals("No roots", Solver.findRoots(a, b, c));
        c = 0;
        Assert.assertEquals("Any numbers", Solver.findRoots(a, b, c));
        b = 1;
        c = 1;
        x = -(b/c);
        Assert.assertEquals(String.format("%f\n", x), Solver.findRoots(a, b, c));
        a = 1;
        b = 0;
        c = 1;
        Assert.assertEquals("D<0\n", Solver.findRoots(a, b, c));
        b = 2;
        x = (-b / (2 * a));
        Assert.assertEquals(String.format("%f\n", x), Solver.findRoots(a, b, c));
        b = 4;
        double discriminant = sqrt(pow(b, 2) - 4 * a * c);
        double x1 = (-b + discriminant) / (2 * a);
        double x2 = (-b - discriminant) / (2 * a);
        Assert.assertEquals(String.format("%f, %f\n", x1, x2), Solver.findRoots(a, b, c));
    }
}