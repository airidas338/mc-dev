package net.minecraft.server;

public class bgk {

   private final short[] a = new short[65536];
   private final IBlock b;


   public bgk() {
      this.b = aty.a.P();
   }

   public IBlock a(int var1, int var2, int var3) {
      int var4 = var1 << 12 | var3 << 8 | var2;
      return this.a(var4);
   }

   public IBlock a(int var1) {
      if(var1 >= 0 && var1 < this.a.length) {
         IBlock var2 = (IBlock)Block.d.a(this.a[var1]);
         return var2 != null?var2:this.b;
      } else {
         throw new IndexOutOfBoundsException("The coordinate is out of range");
      }
   }

   public void a(int var1, int var2, int var3, IBlock var4) {
      int var5 = var1 << 12 | var3 << 8 | var2;
      this.a(var5, var4);
   }

   public void a(int var1, IBlock var2) {
      if(var1 >= 0 && var1 < this.a.length) {
         this.a[var1] = (short)Block.d.b(var2);
      } else {
         throw new IndexOutOfBoundsException("The coordinate is out of range");
      }
   }
}
