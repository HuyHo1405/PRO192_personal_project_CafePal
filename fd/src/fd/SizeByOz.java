
package fd;

public enum SizeByOz {
    SMALL(6.0),
    MEDIUM(8.0),
    LARGE(10.0);
    
    private final double oz;

    private SizeByOz(double oz) {
        this.oz = oz;
    }

    public double getOz() {
        return oz;
    }
    
    public static SizeByOz[] getSizeByOz(){
        return new SizeByOz[]{SMALL, MEDIUM, LARGE};
    }
    
    
    
}
