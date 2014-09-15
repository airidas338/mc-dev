package net.minecraft.server;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class NBTTagDouble extends NBTNumber {

	private double b;

	NBTTagDouble() {
	}

	public NBTTagDouble(double var1) {
		this.b = var1;
	}

	void a(DataOutput var1) throws IOException {
		var1.writeDouble(this.b);
	}

	void a(DataInput var1, int var2, NBTReadLimiter var3) throws IOException {
		var3.a(64L);
		this.b = var1.readDouble();
	}

	public byte getTypeId() {
		return (byte) 6;
	}

	public String toString() {
		return "" + this.b + "d";
	}

	public NBTBase b() {
		return new NBTTagDouble(this.b);
	}

	public boolean equals(Object var1) {
		if (super.equals(var1)) {
			NBTTagDouble var2 = (NBTTagDouble) var1;
			return this.b == var2.b;
		} else {
			return false;
		}
	}

	public int hashCode() {
		long var1 = Double.doubleToLongBits(this.b);
		return super.hashCode() ^ (int) (var1 ^ var1 >>> 32);
	}

	public long c() {
		return (long) Math.floor(this.b);
	}

	public int d() {
		return MathHelper.floor(this.b);
	}

	public short e() {
		return (short) (MathHelper.floor(this.b) & '\uffff');
	}

	public byte f() {
		return (byte) (MathHelper.floor(this.b) & 255);
	}

	public double g() {
		return this.b;
	}

	public float h() {
		return (float) this.b;
	}
}
