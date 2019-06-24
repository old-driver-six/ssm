import com.bj186.oas.mapper.AnnouncementsMapper;
import com.bj186.oas.pojo.Announcements;
import com.bj186.oas.pojo.Contract;
import com.bj186.oas.pojo.Pay;
import com.bj186.oas.pojo.Staff;
import com.bj186.oas.service.common.NoticeService;
import com.bj186.oas.service.personal.ContractService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class TestContract {
    private ApplicationContext context;
    private ContractService contractService;
    @Before
    public void init(){
        context=new ClassPathXmlApplicationContext("config/spring.xml");
        contractService = context.getBean(ContractService.class);
    }
    @Test
    public void insertContract(){
        Contract contract = new Contract();
        Staff staff = new Staff();
        Pay pay = new Pay();
        pay.setPayId(10008);
        pay.setPayStaffid(10008);
        staff.setStaffId(10008);
        staff.setStaffWage("10000");
        contract.setContractId("123456789");
        contract.setContractSecondparty("叶");
        contract.setContractContent("打工啦");
        contract.setStaff(staff);
        contract.setPay(pay);
        Integer integer = contractService.insertContract(contract);
        System.out.println(integer);
    }

    @Test
    public void selectStaffInTheContract(){
        Staff staff = contractService.selectStaffInTheContract(10001);
        System.out.println(staff);
    }
    @Test
    public void  selectAllContracts(){
        List<Contract> contractList = contractService.selectAllConatracts(10001, null,"1", "10");
        System.out.println(contractList);
    }
}
