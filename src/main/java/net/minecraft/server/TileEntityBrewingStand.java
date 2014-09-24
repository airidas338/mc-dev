package net.minecraft.server;

import java.util.Arrays;
import java.util.List;

public class TileEntityBrewingStand extends TileEntityLockable implements IUpdatePlayerListBox, IWorldInventory {

    private static final int[] a = new int[] { 3 };
    private static final int[] f = new int[] { 0, 1, 2 };
    private ItemStack[] g = new ItemStack[4];
    private int h;
    private boolean[] i;
    private Item j;
    private String k;

    public String getName() {
        return this.k_() ? this.k : "container.brewing";
    }

    public boolean k_() {
        return this.k != null && this.k.length() > 0;
    }

    public void a(String var1) {
        this.k = var1;
    }

    public int n_() {
        return this.g.length;
    }

    public void c() {
        if (this.h > 0) {
            --this.h;
            if (this.h == 0) {
                this.o();
                this.o_();
            } else if (!this.n()) {
                this.h = 0;
                this.o_();
            } else if (this.j != this.g[3].b()) {
                this.h = 0;
                this.o_();
            }
        } else if (this.n()) {
            this.h = 400;
            this.j = this.g[3].b();
        }

        if (!this.b.isStatic) {
            boolean[] var1 = this.m();
            if (!Arrays.equals(var1, this.i)) {
                this.i = var1;
                IBlockData var2 = this.b.getData(this.v());
                if (!(var2.c() instanceof BlockBrewingStand)) {
                    return;
                }

                for (int var3 = 0; var3 < BlockBrewingStand.a.length; ++var3) {
                    var2 = var2.a(BlockBrewingStand.a[var3], Boolean.valueOf(var1[var3]));
                }

                this.b.setTypeAndData(this.c, var2, 2);
            }
        }

    }

    private boolean n() {
        if (this.g[3] != null && this.g[3].b > 0) {
            ItemStack var1 = this.g[3];
            if (!var1.b().l(var1)) {
                return false;
            } else {
                boolean var2 = false;

                for (int var3 = 0; var3 < 3; ++var3) {
                    if (this.g[var3] != null && this.g[var3].b() == Items.POTION) {
                        int var4 = this.g[var3].i();
                        int var5 = this.c(var4, var1);
                        if (!ItemPotion.f(var4) && ItemPotion.f(var5)) {
                            var2 = true;
                            break;
                        }

                        List var6 = Items.POTION.e(var4);
                        List var7 = Items.POTION.e(var5);
                        if ((var4 <= 0 || var6 != var7) && (var6 == null || !var6.equals(var7) && var7 != null) && var4 != var5) {
                            var2 = true;
                            break;
                        }
                    }
                }

                return var2;
            }
        } else {
            return false;
        }
    }

    private void o() {
        if (this.n()) {
            ItemStack var1 = this.g[3];

            for (int var2 = 0; var2 < 3; ++var2) {
                if (this.g[var2] != null && this.g[var2].b() == Items.POTION) {
                    int var3 = this.g[var2].i();
                    int var4 = this.c(var3, var1);
                    List var5 = Items.POTION.e(var3);
                    List var6 = Items.POTION.e(var4);
                    if ((var3 <= 0 || var5 != var6) && (var5 == null || !var5.equals(var6) && var6 != null)) {
                        if (var3 != var4) {
                            this.g[var2].b(var4);
                        }
                    } else if (!ItemPotion.f(var3) && ItemPotion.f(var4)) {
                        this.g[var2].b(var4);
                    }
                }
            }

            if (var1.b().r()) {
                this.g[3] = new ItemStack(var1.b().q());
            } else {
                --this.g[3].b;
                if (this.g[3].b <= 0) {
                    this.g[3] = null;
                }
            }

        }
    }

    private int c(int var1, ItemStack var2) {
        return var2 == null ? var1 : (var2.b().l(var2) ? PotionBrewer.a(var1, var2.b().j(var2)) : var1);
    }

    public void a(NBTTagCompound var1) {
        super.a(var1);
        NBTTagList var2 = var1.getList("Items", 10);
        this.g = new ItemStack[this.n_()];

        for (int var3 = 0; var3 < var2.size(); ++var3) {
            NBTTagCompound var4 = var2.get(var3);
            byte var5 = var4.getByte("Slot");
            if (var5 >= 0 && var5 < this.g.length) {
                this.g[var5] = ItemStack.a(var4);
            }
        }

        this.h = var1.getShort("BrewTime");
        if (var1.hasKeyOfType("CustomName", 8)) {
            this.k = var1.getString("CustomName");
        }

    }

    public void b(NBTTagCompound var1) {
        super.b(var1);
        var1.setShort("BrewTime", (short) this.h);
        NBTTagList var2 = new NBTTagList();

        for (int var3 = 0; var3 < this.g.length; ++var3) {
            if (this.g[var3] != null) {
                NBTTagCompound var4 = new NBTTagCompound();
                var4.setByte("Slot", (byte) var3);
                this.g[var3].b(var4);
                var2.add((NBTBase) var4);
            }
        }

        var1.set("Items", (NBTBase) var2);
        if (this.k_()) {
            var1.setString("CustomName", this.k);
        }

    }

    public ItemStack a(int var1) {
        return var1 >= 0 && var1 < this.g.length ? this.g[var1] : null;
    }

    public ItemStack a(int var1, int var2) {
        if (var1 >= 0 && var1 < this.g.length) {
            ItemStack var3 = this.g[var1];
            this.g[var1] = null;
            return var3;
        } else {
            return null;
        }
    }

    public ItemStack b(int var1) {
        if (var1 >= 0 && var1 < this.g.length) {
            ItemStack var2 = this.g[var1];
            this.g[var1] = null;
            return var2;
        } else {
            return null;
        }
    }

    public void a(int var1, ItemStack var2) {
        if (var1 >= 0 && var1 < this.g.length) {
            this.g[var1] = var2;
        }

    }

    public int p_() {
        return 64;
    }

    public boolean a(EntityHuman var1) {
        return this.b.getTileEntity(this.c) != this ? false : var1.e((double) this.c.n() + 0.5D, (double) this.c.o() + 0.5D, (double) this.c.p() + 0.5D) <= 64.0D;
    }

    public void b(EntityHuman var1) {
    }

    public void c(EntityHuman var1) {
    }

    public boolean b(int var1, ItemStack var2) {
        return var1 == 3 ? var2.b().l(var2) : var2.b() == Items.POTION || var2.b() == Items.bA;
    }

    public boolean[] m() {
        boolean[] var1 = new boolean[3];

        for (int var2 = 0; var2 < 3; ++var2) {
            if (this.g[var2] != null) {
                var1[var2] = true;
            }
        }

        return var1;
    }

    public int[] a(EnumFacing var1) {
        return var1 == EnumFacing.UP ? a : f;
    }

    public boolean a(int var1, ItemStack var2, EnumFacing var3) {
        return this.b(var1, var2);
    }

    public boolean b(int var1, ItemStack var2, EnumFacing var3) {
        return true;
    }

    public String k() {
        return "minecraft:brewing_stand";
    }

    public aib a(ahb var1, EntityHuman var2) {
        return new aii(var1, this);
    }

    public int a_(int var1) {
        switch (var1) {
        case 0:
            return this.h;
        default:
            return 0;
        }
    }

    public void b(int var1, int var2) {
        switch (var1) {
        case 0:
            this.h = var2;
        default:
        }
    }

    public int g() {
        return 1;
    }

    public void l() {
        for (int var1 = 0; var1 < this.g.length; ++var1) {
            this.g[var1] = null;
        }

    }

}
