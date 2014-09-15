package net.minecraft.server;

import com.google.common.collect.Lists;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class NBTTagList extends NBTBase {

    private static final Logger b = LogManager.getLogger();
    private List c = Lists.newArrayList();
    private byte d = 0;

    void write(DataOutput var1) throws IOException {
        if (!this.c.isEmpty()) {
            this.d = ((NBTBase) this.c.get(0)).getTypeId();
        } else {
            this.d = 0;
        }

        var1.writeByte(this.d);
        var1.writeInt(this.c.size());

        for (int var2 = 0; var2 < this.c.size(); ++var2) {
            ((NBTBase) this.c.get(var2)).write(var1);
        }

    }

    void load(DataInput var1, int var2, NBTReadLimiter var3) throws IOException {
        if (var2 > 512) {
            throw new RuntimeException("Tried to read NBT tag with too high complexity, depth > 512");
        } else {
            var3.a(8L);
            this.d = var1.readByte();
            int var4 = var1.readInt();
            this.c = Lists.newArrayList();

            for (int var5 = 0; var5 < var4; ++var5) {
                NBTBase var6 = NBTBase.a(this.d);
                var6.load(var1, var2 + 1, var3);
                this.c.add(var6);
            }

        }
    }

    public byte getTypeId() {
        return (byte) 9;
    }

    public String toString() {
        String var1 = "[";
        int var2 = 0;

        for (Iterator var3 = this.c.iterator(); var3.hasNext(); ++var2) {
            NBTBase var4 = (NBTBase) var3.next();
            var1 = var1 + "" + var2 + ':' + var4 + ',';
        }

        return var1 + "]";
    }

    public void add(NBTBase var1) {
        if (this.d == 0) {
            this.d = var1.getTypeId();
        } else if (this.d != var1.getTypeId()) {
            b.warn("Adding mismatching tag types to tag list");
            return;
        }

        this.c.add(var1);
    }

    public void a(int var1, NBTBase var2) {
        if (var1 >= 0 && var1 < this.c.size()) {
            if (this.d == 0) {
                this.d = var2.getTypeId();
            } else if (this.d != var2.getTypeId()) {
                b.warn("Adding mismatching tag types to tag list");
                return;
            }

            this.c.set(var1, var2);
        } else {
            b.warn("index out of bounds to set tag in tag list");
        }
    }

    public NBTBase a(int var1) {
        return (NBTBase) this.c.remove(var1);
    }

    public boolean isEmpty() {
        return this.c.isEmpty();
    }

    public NBTTagCompound get(int var1) {
        if (var1 >= 0 && var1 < this.c.size()) {
            NBTBase var2 = (NBTBase) this.c.get(var1);
            return var2.getTypeId() == 10 ? (NBTTagCompound) var2 : new NBTTagCompound();
        } else {
            return new NBTTagCompound();
        }
    }

    public int[] c(int var1) {
        if (var1 >= 0 && var1 < this.c.size()) {
            NBTBase var2 = (NBTBase) this.c.get(var1);
            return var2.getTypeId() == 11 ? ((NBTTagIntArray) var2).c() : new int[0];
        } else {
            return new int[0];
        }
    }

    public double d(int var1) {
        if (var1 >= 0 && var1 < this.c.size()) {
            NBTBase var2 = (NBTBase) this.c.get(var1);
            return var2.getTypeId() == 6 ? ((NBTTagDouble) var2).g() : 0.0D;
        } else {
            return 0.0D;
        }
    }

    public float e(int var1) {
        if (var1 >= 0 && var1 < this.c.size()) {
            NBTBase var2 = (NBTBase) this.c.get(var1);
            return var2.getTypeId() == 5 ? ((NBTTagFloat) var2).h() : 0.0F;
        } else {
            return 0.0F;
        }
    }

    public String getString(int var1) {
        if (var1 >= 0 && var1 < this.c.size()) {
            NBTBase var2 = (NBTBase) this.c.get(var1);
            return var2.getTypeId() == 8 ? var2.a_() : var2.toString();
        } else {
            return "";
        }
    }

    public NBTBase g(int var1) {
        return (NBTBase) (var1 >= 0 && var1 < this.c.size() ? (NBTBase) this.c.get(var1) : new fr());
    }

    public int size() {
        return this.c.size();
    }

    public NBTBase clone() {
        NBTTagList var1 = new NBTTagList();
        var1.d = this.d;
        Iterator var2 = this.c.iterator();

        while (var2.hasNext()) {
            NBTBase var3 = (NBTBase) var2.next();
            NBTBase var4 = var3.clone();
            var1.c.add(var4);
        }

        return var1;
    }

    public boolean equals(Object var1) {
        if (super.equals(var1)) {
            NBTTagList var2 = (NBTTagList) var1;
            if (this.d == var2.d) {
                return this.c.equals(var2.c);
            }
        }

        return false;
    }

    public int hashCode() {
        return super.hashCode() ^ this.c.hashCode();
    }

    public int f() {
        return this.d;
    }

}
