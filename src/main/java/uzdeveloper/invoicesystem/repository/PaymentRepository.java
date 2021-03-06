package uzdeveloper.invoicesystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uzdeveloper.invoicesystem.entity.Payment;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {

    @Query(value = "select sum(p.amount) from Payment p where p.invoice.id=?1")
    Double getByInvoiceId(Integer id);

    @Query(value = "select p.invoice.id from Payment p group by p.invoice.id order by p.invoice.id")
    List<Integer> getByInvoice();


}
