package ranking;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author demys
 */
public class VotesCompiler {

    private final Map<String, Integer> validMap;
    private final Map<String, Integer> invalidMap;

    public VotesCompiler() {
        validMap = new TreeMap<>();
        invalidMap = new TreeMap<>();
    }

    public void compile(List<CompanyVotes> companies) {
        System.out.println("Sumary by Company:");
        System.out.println();
        companies.forEach(company -> {
            validMap.put(company.getCompanyName(), company.getValidAnswers());
            invalidMap.put(company.getCompanyName(), company.getInvalidAnswers());
            printCompanyResults(company);
        });
        printComputeAnswer();
    }

    private void printCompanyResults(CompanyVotes company) {
        System.out.println(company.getCompanyName());
        company.getPercentStatusById().entrySet().forEach(et -> {
            StringBuilder sb = new StringBuilder();
            sb.append(et.getKey()).append(": ");
            et.getValue().entrySet().forEach(vl -> {
                sb.append(vl.getValue()).append("% ").append(vl.getKey()).append(", ");
            });
            sb.delete(sb.length() - 2, sb.length());
            System.out.println(sb.toString());
        });
        
        System.out.println("");
        
    }
    
    private void printComputeAnswer() {
        printMap("Valid Answers", validMap);
        printMap("Invalid Answers", invalidMap);
    }
    
    private void printMap(String title, Map<String, Integer> map) {
        System.out.println(title + ":");
        System.out.println("");
        map.entrySet().forEach(et -> {
            System.out.println(et.getKey() + ": " + et.getValue());
        });
        System.out.println("");
    }

}
