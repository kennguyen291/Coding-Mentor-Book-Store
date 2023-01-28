package coding.mentor.entity;

public class Book {
	private int id;
	private int categoryId;
	private String name;
	private String description;
	
	public Book(int id, int categoryId, String name, String description) {
		super();
		this.id = id;
		this.categoryId = categoryId;
		this.name = name;
		this.description = description;
	}
	
	

	public Book(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}
	
	public Book(String name, String description, int categoryId) {
		super();
		this.name = name;
		this.description = description;
		this.categoryId = categoryId;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	

}
