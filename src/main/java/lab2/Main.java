package lab2;
import lab2.UI.UI;
import lab2.Repository.NoteRepo;
import lab2.Repository.StudentRepo;
import lab2.Repository.TemeRepo;
import lab2.Service.ServiceNote;
import lab2.Service.ServiceStudent;
import lab2.Service.ServiceTeme;
import lab2.Validator.NotaValidator;
import lab2.Validator.StudentValidator;
import lab2.Validator.TemeValidator;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException{
        StudentRepo rep=new StudentRepo(new StudentValidator(),"src/studenti.xml");
        TemeRepo repo=new TemeRepo(new TemeValidator(),"src/teme.xml");
        NoteRepo r=new NoteRepo(new NotaValidator());
        ServiceStudent srv=new ServiceStudent(rep);
        ServiceTeme serv=new ServiceTeme(repo);
        ServiceNote sv=new ServiceNote(r);
        UI ui=new UI(srv,serv,sv);
        ui.show();

    }
}
