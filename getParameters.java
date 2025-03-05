import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "getParameters", value = "/getParameters")
public class getParameters extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        double loanAmount = Double.parseDouble(request.getParameter("loanAmount"));
        double annualInterestRate = Double.parseDouble(request.getParameter("annualInterestRate"));
        int numberOfYears = Integer.parseInt(request.getParameter("numberOfYears"));

        Loan loan = new Loan(annualInterestRate,numberOfYears,loanAmount);

        double monthlyPayment = loan.getMonthlyPayment();
        double totalPayment = loan.getTotalPayment();

        out.println("</b><br> Loan Amount: <b>" + loanAmount + "</b> Annual Interest Rate: <b>" +
                annualInterestRate + "</b> Number of Years: <b>" + numberOfYears + "</b><br>" + "<b> " +
                "Monthly Payment: <b>" + monthlyPayment + "<b> Total Payment: <b>" + totalPayment);

    }

}