package ranking;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author demys
 */
public class Ranking {

    public static void main(String[] args) {
        List<CompanyVotes> companies = new Ranking().companiesByFiles();
        new VotesCompiler().compile(companies);
    }

    private List<CompanyVotes> companiesByFiles() {
        List<CompanyVotes> companies = new ArrayList<>();
        File directory = new File("files");
        if (directory.exists()) {
            List<File> files = Arrays.asList(directory.listFiles());
            files.forEach(file -> {
                List<String> lines = new FileUtil().readFile(file);
                String companyName = lines.get(0);
                List<Vote> votes = new StringToVotes().convertLines(lines);
                CompanyVotes company = new CompanyVotes(companyName, votes);
                companies.add(company);
            });
        }
        return companies;
    }
}

