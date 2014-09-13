package net.minecraft.server;

public interface IPlayerFileData {

   void save(EntityHuman var1);

   NBTTagCompound load(EntityHuman var1);

   String[] getSeenPlayers();
}
