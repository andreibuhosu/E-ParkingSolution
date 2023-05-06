package acb54.eparkingsolution.repository;

import acb54.eparkingsolution.model.Message;
import acb54.eparkingsolution.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> findByReceiverOrderBySentDateTimeDesc(User recipient);
//    List<Message> findByRecipientOrderByTimestampDesc(User recipient);
//    List<Message> findByRecipientOrderByTimestampDesc(User recipient);

}
