package org.becelot.becelotUtils;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.util.Vector;


/**
 * Represents a world vector. Useful, if you need all implemented Vector operations,
 * but need to convert the vector to a location later
 * @author Benedict
 *
 */
public class WorldVector extends Vector {
	protected World w = null;
	
	/**
	 * Construct a zero vector, given the specified world
	 * @param world The world, this vector belongs to
	 */
	public WorldVector(World world) {
		super();
		this.w = world;
	}
	
	/**
	 * Construct the Vector with provided integer components and a world, this vector belongs to
	 * @param world The world, this vector belongs to
	 * @param x X component
	 * @param y Y component
	 * @param z Z component
	 */
	public WorldVector(World world, int x, int y, int z) {
		super(x, y, z);
		this.w = world;
	}
	
	/**
	 * Construct the Vector with provided float components and a world, this vector belongs to
	 * @param world The world, this vector belongs to
	 * @param x X component
	 * @param y Y component
	 * @param z Z component
	 */
	public WorldVector(World world, float x, float y, float z) {
		super(x, y, z);
		this.w = world;
	}
	
	/**
	 * Construct the Vector with provided double components and a world, this vector belongs to
	 * @param world The world, this vector belongs to
	 * @param x X component
	 * @param y Y component
	 * @param z Z component
	 */
	public WorldVector(World world, double x, double y, double z) {
		super(x, y, z);
		this.w = world;
	}
	
	/**
	 * Convert this vector into a location
	 * @return Location
	 */
	public Location toLocation() {
		return new Location(w, x, y, z);
	}
	
	/**
	 * Set the world for this vector
	 * @param world World
	 * @return This WorldVector instance
	 */
	public WorldVector setWorld(World world) {
		w = world;
		return this;
	}
	
	/**
	 * Convert this vector into a location with pitch and yaw
	 * @param yaw Yaw
	 * @param pitch Pitch
	 * @return Location
	 */
	public Location toLocation(float yaw, float pitch) {
		return new Location(w, x, y, z, yaw, pitch);
	}
}
