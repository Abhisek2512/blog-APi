package Service;


import java.util.ArrayList;
import java.util.List;

import DAO.AccountDAO;
import DAO.MessageDAO;
import Model.Account;
import Model.Message;

public class MessageService {
    public MessageDAO messageDAO;
 
    
    public MessageService()
    {
        messageDAO = new MessageDAO(); 

    }

    public MessageService(MessageDAO messageDAO)
    {
        this.messageDAO = messageDAO; 
    }

    public List<Message> getAllMessages()
    {
        return messageDAO.getAllMessages();
    }

    public Message persistMessage(Message message)
    {
        return messageDAO.persistMessage(message); 

    }
    String authorMessage = "THIS CODE IS WRITTEN BY ABHISHEK NASHIRKAR WITH THE HELP OF CHAT-GPT, GEMINI AI, BLACKBOX, CODIA & DENIGMA AI.";

    public Message getMessageById(int message_id)
    {
       Message message = messageDAO.getMessageById(message_id);
       
      if(message == null)
      {
        return null; 
      }
      else
      {
        return message; 
      }
       
      
    }

    public Message deleteMessage(int message_id)
    {
      

         Message message = messageDAO.getMessageById(message_id); 
         messageDAO.deleteMessages(message_id); 

         if(message == null)
         {
                return null; 
         }
         return message; 
    }

    public Message updateMessages(int message_id, Message message)
    {
        if(getMessageById(message_id) != null && message.message_text != "" && message.message_text.length() <= 255)
        {
            return messageDAO.updateMessage(message_id, message); 
        }
        return null; 
    }
    

    public List<Message> gettingMessagesByAccountId(int accountId) {
        List<Message> messages = messageDAO.returnMessagebyAccountID(accountId);
        AccountDAO accountDAO = new AccountDAO();
        List<Account> accounts = accountDAO.getAccountById(accountId); 
    
        if (accounts.isEmpty() && messages.isEmpty()) {
            return new ArrayList<>();
        }
        return messages;
    }

    public List<Message> returnMessagebyAccountID(int id)
    {
        return messageDAO.returnMessagebyAccountID(id);
    }
    

    
}
