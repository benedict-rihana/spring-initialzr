package benedict.zhang.datamodel;

public enum ProjectType {
    GRADLE("gradle-project");


    private String typeName;
    ProjectType(String typeName){
        this.typeName = typeName;
    }


    @Override
    public String toString() {
        return typeName;
    }
}
