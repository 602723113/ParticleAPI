package de.devtastisch.particleapi.api.matrix.action;

import de.devtastisch.particleapi.api.matrix.MatrixAction;
import de.devtastisch.particleapi.api.matrix.MatrixLocation;
import de.devtastisch.particleapi.api.particle.ParticleEffect;
import lombok.AllArgsConstructor;
import lombok.Data;
import de.devtastisch.particleapi.api.matrix.Matrix3D;
import org.bukkit.World;

/**
 * Implementation from {@link MatrixAction} to draw a line between two relative locations in a {@link Matrix3D}
 */
@AllArgsConstructor
@Data
public class DrawLine implements MatrixAction {

    private ParticleEffect particleEffect;
    private MatrixLocation location1;
    private MatrixLocation location2;

    @Override
    public void execute(World world, Matrix3D matrix3D) {
        double xdif = location2.getX() - location1.getX();
        double ydif = location2.getY() - location1.getY();
        double zdif = location2.getZ() - location1.getZ();

        for (double i = 0; i <= 1 ; i+=0.02) {
            matrix3D.paint(world, new MatrixLocation((xdif * i) + (xdif < 0 ? -1 : 1) * Math.min(location1.getX(), location2.getX()), (ydif * i) + (ydif < 0 ? -1 : 1) * Math.min(location1.getY(), location2.getY()), (zdif * i) + (zdif < 0 ? -1 : 1) * Math.min(location1.getZ(), location2.getZ())), particleEffect);
        }

    }

}
