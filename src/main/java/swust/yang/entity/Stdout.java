package swust.yang.entity;

public class Stdout {
	/**
	 * {'status': 0, 'max_memory': 23328L, 'max_time': 207L}
	 */
	
	private Integer status;
	
	private Long max_memory;
	
	private Long max_time;
	
	
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Long getMax_memory() {
		return max_memory;
	}
	public void setMax_memory(Long max_memory) {
		this.max_memory = max_memory;
	}
	public Long getMax_time() {
		return max_time;
	}
	public void setMax_time(Long max_time) {
		this.max_time = max_time;
	}
}
