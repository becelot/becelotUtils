package org.becelot.becelotUtils.regions;

import java.io.Serializable;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;


public class Cuboid implements Serializable, Cloneable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8367925644276742293L;
	
	protected String worldName;
	protected int x1, y1, z1;
	protected int x2, y2, z2;
	
	/**
	 * Construct a cuboid given two Locations representing any
	 * corners of the cuboid
	 * 
	 * @param l1 Location 1
	 * @param l2 Location 2
	 */
	public Cuboid(Location l1, Location l2) {
		if (l1.getWorld().getName() != l2.getWorld().getName()) {
			throw new IllegalArgumentException("Locations must be on the same world!");
		}
		
		x1 = Math.min(l1.getBlockX(), l2.getBlockX());
		y1 = Math.min(l1.getBlockY(), l2.getBlockY());
		z1 = Math.min(l1.getBlockZ(), l2.getBlockZ());
		x2 = Math.max(l1.getBlockX(), l2.getBlockX());
		y2 = Math.max(l1.getBlockY(), l2.getBlockY());
		z2 = Math.max(l1.getBlockZ(), l2.getBlockZ());
	}
	
	/**
	 * Construct a new 1x1x1 cuboid 
	 * 
	 * @param l Location
	 */
	public Cuboid(Location l) {
		this(l, l);
	}
	
	/**
	 * Construct a cuboid give the components of two corners
	 * @param world World, in which the cuboid should be constructed
	 * @param x1 X1 Component
	 * @param y1 Y1 Component
	 * @param z1 Z1 Component
	 * @param x2 X2 Component
	 * @param y2 Y2 Component
	 * @param z2 Z2 Component
	 */
	public Cuboid(World world, int x1, int y1, int z1, int x2, int y2, int z2) {
		worldName = world.getName();
		
		this.x1 = Math.min(x1, x2);
		this.y1 = Math.min(y1, y2);
		this.z1 = Math.min(z1, z2);
		this.x2 = Math.max(x1, x2);
		this.y2 = Math.max(y1, y2);
		this.z2 = Math.max(z1, z2);
	}
	
	/**
	 * Construct a cuboid give the components of two corners
	 * @param worldName World, in which the cuboid should be constructed
	 * @param x1 X1 Component
	 * @param y1 Y1 Component
	 * @param z1 Z1 Component
	 * @param x2 X2 Component
	 * @param y2 Y2 Component
	 * @param z2 Z2 Component
	 */
	public Cuboid(String worldName, int x1, int y1, int z1, int x2, int y2, int z2) {
		this.worldName = worldName;
		
		this.x1 = Math.min(x1, x2);
		this.y1 = Math.min(y1, y2);
		this.z1 = Math.min(z1, z2);
		this.x2 = Math.max(x1, x2);
		this.y2 = Math.max(y1, y2);
		this.z2 = Math.max(z1, z2);
	}
	
	/**
	 * Construct a cuboid given an other cuboid.
	 * @param other Other cuboid
	 */
	public Cuboid(Cuboid other) {
		this(other.worldName, other.x1, other.y1, other.z1, other.x2, other.y2, other.z2);
	}
	
	public boolean contains(int x, int y, int z) {
		return x >= x1 && x <= x2 && y >= y1 && y <= y2 && z >= z1 && z <= z2;
	}
	
	public boolean contains(Location l) {
		return contains(l.getBlockX(), l.getBlockY(), l.getBlockZ());
	}
	
	public boolean contains(Block b) {
		return contains(b.getLocation());
	}
	
	@Override
	public Cuboid clone() {
		return new Cuboid(this);
	}
}
