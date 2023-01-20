import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class EmailApp {
    public static void main(String[] args) {
        // get the list of emails
        List<Email> emails=new ArrayList<>();
        emails.add(new Email(" ","info@parkshark.com","","Thanks for Promo","Promo"));
        emails.add(new Email(" ","info@parkshark.com","","I want to do advertising","My books advertising"));
        emails.add(new Email(" ","info@parkshark.com","","This is my business proposal","About my Company's"));
        emails.add(new Email(" ","info@parkshark.com","","This is my 2nd proposal","To sales my house"));
        emails.add(new Email(" ","info@parkshark.com","","Find below my Cv","About my cv"));
        emails.add(new Email(" ","info@parkshark.com","","I want to learn english","To get information about my java course"));
        emails.add(new Email(" ","info@parkshark.com","","Can i make an appointment?","about info"));
        emails.add(new Email(" ","info@parkshark.com","","I want to follow this Course","Dutch course"));
        emails.add(new Email(" ","info@parkshark.com","","This is my Cv","About job"));
        emails.add(new Email(" ","info@parkshark.com","","Cv","About junior job "));
        emails.add(new Email(" ","info@parkshark.com","","can you correct my Cv please?","To correct my cv"));
        emails.add(new Email(" ","info@parkshark.com","","Cv of java developer","To "));

        //declare the particular list to store the mails
        List<Email>spamList=new ArrayList<>();
        List<Email>proposalList=new ArrayList<>();
        List<Email>recepList=new ArrayList<>();
        List<Email>cvList=new ArrayList<>();

        //select the emails from the list to store the particular list
           emails.forEach(em->{
            if(em.getEmailText().contains("Promo")||em.getEmailText().contains("advertising")){
                // forward mail /send em
                em.setTo("spam@parkshark.com");
                //add to the spamList
                spamList.add(em);
            }
            else if(em.getEmailText().contains("proposal")){
                //forward mail
                em.setTo("sales@parkshark.com");
                //add to the list for the count
                proposalList.add(em);

            }
            else if(em.getEmailText().contains("Cv")){
                em.setTo("recruitment@parkshark.com");
                // add to the list
                cvList.add(em);

            }
            else{
                em.setTo("reception@parkshark.com");
                recepList.add(em);
            }
           });

           //deletes the emails
         /*  emails.clear();
           System.out.println(emails);*/

           // sort the emails desired order
           Collections.sort(emails,new EmailSort());
           emails.forEach(e-> System.out.println(e));
           //display total amount of emails sent
           System.out.println("We have sorted "+emails.size()+" mails :");
        //display total amount of emails sent to recruitment
            System.out.println(cvList.size()+" to recruitment");
        //display total amount of emails sent to spam
            System.out.println(spamList.size()+" to spam");
        //display total amount of emails sent to sales or advertisement
            System.out.println(proposalList.size()+" to sales");
        //display total amount of emails sent to reception
            System.out.println(recepList.size()+" to reception");



    }
}



