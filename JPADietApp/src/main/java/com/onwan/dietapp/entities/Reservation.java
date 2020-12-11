package com.onwan.dietapp.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
public class Reservation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "open_date")
	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm")
	private Date openDate;
	@Column(name = "close_date")
	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm")
	private Date closeDate;
	private boolean completed;
	@Column(name = "created_at")
	@CreationTimestamp
	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm")
	private Date createdAt;
	@Column(name = "updated_at")
	@UpdateTimestamp
	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm")
	private Date updatedAt;
	private boolean approved;
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	@ManyToOne
	@JoinColumn(name = "service_id")
	private Service service;
	@OneToMany(mappedBy = "reservation")
	private List<Chat> chat;
	@OneToOne(mappedBy = "reservation")
	private ReviewOfService reviewOfService;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getOpenDate() {
		return openDate;
	}
	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}
	public Date getCloseDate() {
		return closeDate;
	}
	public void setCloseDate(Date closeDate) {
		this.closeDate = closeDate;
	}
	public boolean getCompleted() {
		return completed;
	}
	public void setCompleted(boolean completed) {
		this.completed = completed;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public boolean getApproved() {
		return approved;
	}
	public void setApproved(boolean approved) {
		this.approved = approved;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Service getService() {
		return service;
	}
	public void setService(Service service) {
		this.service = service;
	}
	public List<Chat> getMessages() {
		return chat;
	}
	public void setMessages(List<Chat> chat) {
		this.chat = chat;
	}
	public ReviewOfService getReviewOfService() {
		return reviewOfService;
	}
	public void setReviewOfService(ReviewOfService reviewOfService) {
		this.reviewOfService = reviewOfService;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((openDate == null) ? 0 : openDate.hashCode());
		result = prime * result + ((closeDate == null) ? 0 : openDate.hashCode());
		result = prime * result + (completed ? 1231 : 1237);
		result = prime * result + ((createdAt == null) ? 0 : createdAt.hashCode());
		result = prime * result + ((updatedAt == null) ? 0 : updatedAt.hashCode());
		result = prime * result + (approved ? 1231 : 1237);
		result = prime * result + ((user== null) ? 0 : user.hashCode());
		result = prime * result + ((service == null) ? 0 : service.hashCode());
		result = prime * result + ((chat == null) ? 0 : chat.hashCode());
		result = prime * result + ((reviewOfService == null) ? 0 : reviewOfService.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reservation other = (Reservation) obj;
		if (id != other.id) {
			return false;
		}
		if (openDate == null) {
			if (openDate != other.openDate)
				return false;
		} else if (!openDate.equals(other.openDate))
			return false;
		if (closeDate == null) {
			if (closeDate != other.closeDate)
				return false;
		} else if (!closeDate.equals(other.closeDate))
			return false;
		if (completed != other.completed)
			return false;
		if (createdAt == null) {
			if (createdAt != other.createdAt)
				return false;
		} else if (!createdAt.equals(other.createdAt))
			return false;
		if (approved != other.approved)
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		if (service == null) {
			if (other.service != null)
				return false;
		} else if (!service.equals(other.service))
			return false;
		if (chat == null) {
			if (other.chat != null)
				return false;
		} else if (!chat.equals(other.chat))
			return false;
		if (reviewOfService == null) {
			if (other.reviewOfService != null)
				return false;
		} else if (!reviewOfService.equals(other.reviewOfService))
			return false;
		return true;
	}
	
	public Reservation(int id, Date openDate, Date closeDate, boolean completed, Date createdAt, Date updatedAt, boolean approved,
			User user, Service service, List<Chat> chat, ReviewOfService reviewOfService) {
		super();
		this.id = id;
		this.openDate = openDate;
		this.closeDate = closeDate;
		this.completed = completed;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.approved = approved;
		this.user = user;
		this.service = service;
		this.chat = chat;
		this.reviewOfService = reviewOfService;
	}
	
	public Reservation() {
		super();
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Reservation [id=");
		builder.append(id);
		builder.append(", openDate=");
		builder.append(openDate);
		builder.append(", closeDate=");
		builder.append(closeDate);
		builder.append(", completed=");
		builder.append(completed);
		builder.append(", createdAt=");
		builder.append(createdAt);
		builder.append(", updatedAt");
		builder.append(updatedAt);
		builder.append(", approved=");
		builder.append(approved);
		builder.append(", service=");
		builder.append(service);
		builder.append(", chat=");
		builder.append(chat);
		builder.append(", reviewOfService=");
		builder.append(reviewOfService);
		builder.append("]");
		return builder.toString();
	}
}