package com.simplon.nooky.project.database;

import java.util.HashMap;
import java.util.UUID;

import com.simplon.nooky.project.entities.*;

public class Database {
	//private static HashMap<UUID, User> mapUser = new HashMap<>();
	private static HashMap<UUID, Product> mapProduct = new HashMap<>();
	private static HashMap<UUID, Membership>mapMembership = new HashMap<>();
	private static HashMap<UUID, Category>mapCategory = new HashMap<>();
	private static HashMap<UUID, Community>mapCommunity = new HashMap<>();
	
	/*public static UUID addUser(User user) {
		UUID newUserId = UUID.randomUUID();
		user.setId(newUserId);
		mapUser.put(user.getId(), user);
		return newUserId;
	}
	
	public static User getUserById(UUID id) {
		return mapUser.get(id);
	}*/
	
	public static UUID addProduct(Product product) {
		UUID newProductId = UUID.randomUUID();
		product.setId(newProductId);
		mapProduct.put(product.getId(), product);
		return newProductId;
	}
	
	public static Product getProductById(UUID id) {
		return mapProduct.get(id);
	}
	
	public static UUID addMembership(Membership membership) {
		UUID newMembershipId = UUID.randomUUID();
		membership.setId(newMembershipId);
		mapMembership.put(membership.getId(), membership);
		return newMembershipId;
	}
	
	public static Membership getMembershipById(UUID id) {
		return mapMembership.get(id);
	}
	
	public static UUID addCategory(Category category) {
		UUID newCategoryId = UUID.randomUUID();
		category.setId(newCategoryId);
		mapCategory.put(category.getId(), category);
		return newCategoryId;
	}
	
	public static Category getCategoryById(UUID id) {
		return mapCategory.get(id);
	}
	
	public static UUID addCommunity(Community community) {
		UUID newCommunityId = UUID.randomUUID();
		community.setId(newCommunityId);
		mapCommunity.put(community.getId(), community);
		return newCommunityId;
	}
	
	public static Community getCommunityById(UUID id) {
		return mapCommunity.get(id);
	}
}
