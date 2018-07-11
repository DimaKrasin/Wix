import com.Wix.NumbersUtils;
import org.junit.Assert;
import org.junit.Test;

public class convertTralfamadorianToDecimalTest {
    private  String alphabetFileName = "Alphabet.txt";

    @Test
    public void test1withVerticalBar(){
        Integer result = NumbersUtils.convertTralfamadorianToDecimal("α|",alphabetFileName);
        Assert.assertEquals("α|",new Integer(1),result);
    }

    @Test
    public void test2withVerticalBar(){
        Integer result = NumbersUtils.convertTralfamadorianToDecimal("γ++δ+β|",alphabetFileName);
        Assert.assertEquals("γ++δ+β|",new Integer(342),result);
    }
    @Test
    public void test3withVerticalBar(){
        Integer result = NumbersUtils.convertTralfamadorianToDecimal("β+xα+θ|",alphabetFileName);
        Assert.assertEquals("β+xα+θ|",new Integer(2018),result);
    }
    @Test
    public void test4withoutVerticalBar(){
        Integer result = NumbersUtils.convertTralfamadorianToDecimal("ι+x",alphabetFileName);
        Assert.assertEquals("ι+x",new Integer(9000),result);
    }
    @Test
    public void test5withoutVerticalBar(){
        Integer result = NumbersUtils.convertTralfamadorianToDecimal("α+xxα++",alphabetFileName);
        Assert.assertEquals("α+xxα++",new Integer(100100),result);
    }
}
