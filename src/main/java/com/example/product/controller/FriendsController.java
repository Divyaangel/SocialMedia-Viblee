package com.example.product.controller;
 
 
import java.time.LocalDate;
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
 
import com.example.product.exception.*;
import com.example.product.service.FriendsService;
 
import com.example.product.dto.*;
 
import com.example.product.entity.*;
 
 
@RestController
@RequestMapping("/api/v1/friends/")
 
public class FriendsController {
	@Autowired
	FriendsService friendService;
 
	
	@GetMapping("/{friendshipId}/messages")
	public ResponseEntity <List<Message>> retrieveAllMessageBetweenFriends (@PathVariable("friendshipId") int friendshipId)throws UserNotFoundException ,FriendsNotFoundException{
		return new ResponseEntity<List<Message>>
		        (friendService.getAllMessageBetweenFriends(friendshipId), HttpStatus.OK);
  }
   
	
	@PostMapping("/{friendshipId}/{messages}/send")
	public ResponseEntity<String> sendMessageToFriend(@PathVariable("friendshipId")int friendshipId ,@PathVariable("messages")String messages ) throws UserNotFoundException, FriendsNotFoundException{
		return new ResponseEntity<String>
		(friendService.sendMessageToAFriend(friendshipId, messages), HttpStatus.OK);	
  }

	
  @ExceptionHandler({UserNotFoundException.class})
 public ResponseEntity<ExceptionMessage> handleUsersNotFoundException(UserNotFoundException ex){
		ExceptionMessage message = new ExceptionMessage(ex.getMessage());
		return new ResponseEntity<ExceptionMessage>(message, HttpStatus.NOT_FOUND);
			}
  @ExceptionHandler({FriendsNotFoundException.class})
 public ResponseEntity<ExceptionMessage> handleFriendsNotFoundException(FriendsNotFoundException ex){
		ExceptionMessage message = new ExceptionMessage(ex.getMessage());
		return new ResponseEntity<ExceptionMessage>(message, HttpStatus.NOT_FOUND);
  }
 
}