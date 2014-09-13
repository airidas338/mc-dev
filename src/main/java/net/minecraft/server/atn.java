package net.minecraft.server;

final class atn implements Runnable {

   // $FF: synthetic field
   final World a;
   // $FF: synthetic field
   final Location b;


   atn(World var1, Location var2) {
      this.a = var1;
      this.b = var2;
   }

   public void run() {
      Chunk var1 = this.a.f(this.b);

      for(int var2 = this.b.o() - 1; var2 >= 0; --var2) {
         Location var3 = new Location(this.b.n(), var2, this.b.p());
         if(!var1.d(var3)) {
            break;
         }

         IBlock var4 = this.a.getData(var3);
         if(var4.c() == Blocks.BEACON) {
            ((WorldServer)this.a).a((Runnable)(new ato(this, var3)));
         }
      }

   }
}
