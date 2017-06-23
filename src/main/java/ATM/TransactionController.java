package ATM;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;

import ATM.Transaction;
import ATM.TransactionRepository;

@Controller
public class TransactionController {
	@Autowired 
	private TransactionRepository transRepository;
	//private String action;
	
	private int depAmount;
	private int withAmount;
	private int tolAmount;
	
		
	@GetMapping("/deposit") // Map ONLY GET Requests
	public String depositTrans (Model transModel) {
		transModel.addAttribute("deposit", new Transaction());
		Transaction d = new Transaction();
		d.deposit( depAmount);
		return "deposit";
	}
	
	@PostMapping("/deposit")
	public String depositAdded(@ModelAttribute Transaction trans){
		transRepository.save(trans);
		return "Balance";
	}
	
	@GetMapping("/withdraw")
	public String withdrawTrans(){
		Model transModel;
	transModel.addAttribute("withdraw", new Transaction());
	Transaction w = new Transaction();
	w.withdraw(withAmount);
	return "withdraw";
	
	}
	
	@PostMapping("/withdraw")
	public String withdrawAdded(@ModelAttribute Transaction trans){
		transRepository.save(trans);
		return "Balance";
	}
	
	@GetMapping("/history")
	public Iterable<Transaction> displayHistory(){
		return transRepository.findAll();
		
	}
	
	/*@GetMapping("/balance")
	public int displayBalance(){
		return transRepository.findAll();
	}
*/

}
