package net.minecraft.server;

enum EnumProtocolState {

   HELLO("HELLO", 0),
   KEY("KEY", 1),
   AUTHENTICATING("AUTHENTICATING", 2),
   READY_TO_ACCEPT("READY_TO_ACCEPT", 3),
   ACCEPTED("ACCEPTED", 4);
   // $FF: synthetic field
   private static final EnumProtocolState[] f = new EnumProtocolState[]{HELLO, KEY, AUTHENTICATING, READY_TO_ACCEPT, ACCEPTED};


   private EnumProtocolState(String var1, int var2) {}

}
