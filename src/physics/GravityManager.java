package physics;

public class GravityManager {

    private final int GRAVITY_FORCE = 3;

    public int getGravity(int velocity)
    {
        return velocity*GRAVITY_FORCE;
    }

}
