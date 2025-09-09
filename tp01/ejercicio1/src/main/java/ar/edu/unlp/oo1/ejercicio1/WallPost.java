package ar.edu.unlp.oo1.ejercicio1;

/**
 * Completar esta clase de acuerdo a lo especificado
 */
public class WallPost {
	String text = "Undefined post";
	int amount_likes = 0;
	boolean highlighted = false;

	/**
	 * Retorna el texto descriptivo de la publicación
	 * 
	 * @return
	 */

	String getText() {
		return this.text;
	};

	/**
	 * Setea el texto descriptivo de la publicación
	 * @param text
	 */
	void setText(String text) {
		this.text = text;
	};

	/**
	 * Retorna la cantidad de “me gusta”
	 * 
	 * @return
	 */
	int getLikes() {
		return this.amount_likes;
	};

	/**
	 * Incrementa la cantidad de likes en uno
	 */
	void like() {
		this.amount_likes = this.amount_likes + 1;
	};

	/**
	 * Decrementa la cantidad de likes en uno. Si ya es 0, no hace nada
	 */
	void dislike() {
		if (this.amount_likes > 0) {
			this.amount_likes = this.amount_likes - 1;
		}
	};

	/**
	 * Retorna true si el post está marcado como destacado, false en caso contrario
	 * 
	 * @return
	 */
	boolean isFeatured() {
		if (this.highlighted) {
			return true;
		}
		return false;
	};

	/**
	 * Cambia el post del estado destacado a no destacado y viceversa
	 */
	void toggleFeatured() {
		this.highlighted = !this.highlighted;
	};

	/*
	 * Este mensaje se utiliza para que una instancia de Wallpost se muestre de forma adecuada
	 */
	@Override
	public String toString() {
		return "WallPost {" +
			"text: " + getText() +
			", likes: '" + getLikes() + "'" +
			", featured: '" + isFeatured() + "'" +
			"}";
	}

}