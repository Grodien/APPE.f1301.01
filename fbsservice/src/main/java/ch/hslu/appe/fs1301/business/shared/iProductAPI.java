package ch.hslu.appe.fs1301.business.shared;

import java.util.List;

import ch.hslu.appe.fs1301.business.shared.dto.DTOProdukt;

/**
 * The ProductAPI handels everything that has to do with products.
 * @author Sandro Bollhalder
 */
public interface iProductAPI {
	/**
	 * Get all products.
	 * @return A list of all products.
	 * @throws AccessDeniedException If the user hasn't enough rights to execute.
	 */
	public List<DTOProdukt> getAllProducts() throws AccessDeniedException;
	
	/**
	 * Gets a product by id.
	 * @param id The id.
	 * @return The product.
	 * @throws AccessDeniedException If the user hasn't enough rights to execute.
	 */
	public DTOProdukt getProductById(int id) throws AccessDeniedException;

	/**
	 * Saves all changes done to this product or creates a new one.
	 * @param product The product.
	 * @return The updated DTO.
	 * @throws AccessDeniedException If the user hasn't enough rights to execute.
	 */
	DTOProdukt saveProduct(DTOProdukt product) throws AccessDeniedException;
}
