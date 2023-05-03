package spring.mvc.entity;

import javax.persistence.*;


import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="User_Book")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserBook {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id")
	private int id;
	
	@OneToOne
	@JoinColumn(name="user_id", referencedColumnName = "userId")
	private User userId;
	
	@OneToOne
	@JoinColumn(name="book_id", referencedColumnName = "bookId")
	private Book bookId;
	
	@Column(name="read_later")
	private boolean readLater;
	private boolean liked;

}
