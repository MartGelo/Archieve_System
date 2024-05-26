package archivesystem1;

public interface TableActionEvent1 {
    
    public void onEdit(int row);
    
    public void onDelete(int row);
    
    public void onView(int row);
    
    public void onCheck (int row);
    
    public void onDecline(int row);
}
