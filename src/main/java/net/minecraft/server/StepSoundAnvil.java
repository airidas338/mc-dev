package net.minecraft.server;

final class StepSoundAnvil extends StepSound {

   StepSoundAnvil(String var1, float var2, float var3) {
      super(var1, var2, var3);
   }

   public String a() {
      return "dig.stone";
   }

   public String b() {
      return "random.anvil_land";
   }
}
