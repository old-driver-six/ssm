package sandao;

import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.bj186.oas.Util.ExcelListener;
import com.bj186.oas.pojo.CheckingIn;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestExcel {

@Test
public  void test(){
    InputStream inputStream = null;

    try {
        inputStream = new FileInputStream("G:/workspace/ssm/src/Test/java/sandao/Time.xls");
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
    try {

        // 解析每行结果在listener中处理
        ExcelListener listener = new ExcelListener();

        ExcelReader excelReader = new ExcelReader(inputStream, ExcelTypeEnum.XLS, null, listener);
        excelReader.read(new Sheet(1, 1, CheckingIn.class));
        List<Object> datas = listener.getDatas();
        for (Object data : datas) {
            CheckingIn c =(CheckingIn)data;
            System.out.println(c);
        }

    } catch (Exception e) {

    } finally {
        try {
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

}
