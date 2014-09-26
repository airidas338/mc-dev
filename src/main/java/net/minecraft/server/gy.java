package net.minecraft.server;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.Maps;

import gnu.trove.map.TIntObjectMap;
import gnu.trove.map.hash.TIntObjectHashMap;

import java.util.Iterator;
import java.util.Map;

import org.apache.logging.log4j.LogManager;

public enum gy {

    a("HANDSHAKING", 0, -1) {{
        a(EnumPacketDirection.SERVERBOUND, mz.class);
    }}, b("PLAY", 1, 0) {{
        a(EnumPacketDirection.CLIENTBOUND, PacketPlayOutKeepAlive.class);
        a(EnumPacketDirection.CLIENTBOUND, PacketPlayOutLogin.class);
        a(EnumPacketDirection.CLIENTBOUND, PacketPlayOutChat.class);
        a(EnumPacketDirection.CLIENTBOUND, PacketPlayOutUpdateTime.class);
        a(EnumPacketDirection.CLIENTBOUND, PacketPlayOutEntityEquipment.class);
        a(EnumPacketDirection.CLIENTBOUND, PacketPlayOutSpawnPosition.class);
        a(EnumPacketDirection.CLIENTBOUND, PacketPlayOutUpdateHealth.class);
        a(EnumPacketDirection.CLIENTBOUND, PacketPlayOutRespawn.class);
        a(EnumPacketDirection.CLIENTBOUND, PacketPlayOutPosition.class);
        a(EnumPacketDirection.CLIENTBOUND, PacketPlayOutHeldItemSlot.class);
        a(EnumPacketDirection.CLIENTBOUND, PacketPlayOutBed.class);
        a(EnumPacketDirection.CLIENTBOUND, PacketPlayOutAnimation.class);
        a(EnumPacketDirection.CLIENTBOUND, PacketPlayOutNamedEntitySpawn.class);
        a(EnumPacketDirection.CLIENTBOUND, PacketPlayOutCollect.class);
        a(EnumPacketDirection.CLIENTBOUND, PacketPlayOutSpawnEntity.class);
        a(EnumPacketDirection.CLIENTBOUND, PacketPlayOutSpawnEntityLiving.class);
        a(EnumPacketDirection.CLIENTBOUND, PacketPlayOutSpawnEntityPainting.class);
        a(EnumPacketDirection.CLIENTBOUND, PacketPlayOutSpawnEntityExperienceOrb.class);
        a(EnumPacketDirection.CLIENTBOUND, PacketPlayOutEntityVelocity.class);
        a(EnumPacketDirection.CLIENTBOUND, PacketPlayOutEntityDestroy.class);
        a(EnumPacketDirection.CLIENTBOUND, PacketPlayOutEntity.class);
        a(EnumPacketDirection.CLIENTBOUND, jz.class);
        a(EnumPacketDirection.CLIENTBOUND, kb.class);
        a(EnumPacketDirection.CLIENTBOUND, ka.class);
        a(EnumPacketDirection.CLIENTBOUND, PacketPlayOutEntityTeleport.class);
        a(EnumPacketDirection.CLIENTBOUND, PacketPlayOutEntityHeadRotation.class);
        a(EnumPacketDirection.CLIENTBOUND, PacketPlayOutEntityStatus.class);
        a(EnumPacketDirection.CLIENTBOUND, PacketPlayOutAttachEntity.class);
        a(EnumPacketDirection.CLIENTBOUND, PacketPlayOutEntityMetadata.class);
        a(EnumPacketDirection.CLIENTBOUND, PacketPlayOutEntityEffect.class);
        a(EnumPacketDirection.CLIENTBOUND, PacketPlayOutRemoveEntityEffect.class);
        a(EnumPacketDirection.CLIENTBOUND, PacketPlayOutExperience.class);
        a(EnumPacketDirection.CLIENTBOUND, PacketPlayOutUpdateAttributes.class);
        a(EnumPacketDirection.CLIENTBOUND, PacketPlayOutMapChunk.class);
        a(EnumPacketDirection.CLIENTBOUND, PacketPlayOutMultiBlockChange.class);
        a(EnumPacketDirection.CLIENTBOUND, PacketPlayOutBlockChange.class);
        a(EnumPacketDirection.CLIENTBOUND, PacketPlayOutBlockAction.class);
        a(EnumPacketDirection.CLIENTBOUND, PacketPlayOutBlockBreakAnimation.class);
        a(EnumPacketDirection.CLIENTBOUND, PacketPlayOutMapChunkBulk.class);
        a(EnumPacketDirection.CLIENTBOUND, PacketPlayOutExplosion.class);
        a(EnumPacketDirection.CLIENTBOUND, PacketPlayOutWorldEvent.class);
        a(EnumPacketDirection.CLIENTBOUND, PacketPlayOutNamedSoundEffect.class);
        a(EnumPacketDirection.CLIENTBOUND, PacketPlayOutWorldParticles.class);
        a(EnumPacketDirection.CLIENTBOUND, PacketPlayOutGameStateChange.class);
        a(EnumPacketDirection.CLIENTBOUND, PacketPlayOutSpawnEntityWeather.class);
        a(EnumPacketDirection.CLIENTBOUND, PacketPlayOutOpenWindow.class);
        a(EnumPacketDirection.CLIENTBOUND, PacketPlayOutCloseWindow.class);
        a(EnumPacketDirection.CLIENTBOUND, PacketPlayOutSetSlot.class);
        a(EnumPacketDirection.CLIENTBOUND, PacketPlayOutWindowItems.class);
        a(EnumPacketDirection.CLIENTBOUND, PacketPlayOutWindowData.class);
        a(EnumPacketDirection.CLIENTBOUND, PacketPlayOutTransaction.class);
        a(EnumPacketDirection.CLIENTBOUND, PacketPlayOutUpdateSign.class);
        a(EnumPacketDirection.CLIENTBOUND, PacketPlayOutMap.class);
        a(EnumPacketDirection.CLIENTBOUND, PacketPlayOutTileEntityData.class);
        a(EnumPacketDirection.CLIENTBOUND, PacketPlayOutOpenSignEditor.class);
        a(EnumPacketDirection.CLIENTBOUND, PacketPlayOutStatistic.class);
        a(EnumPacketDirection.CLIENTBOUND, PacketPlayOutPlayerInfo.class);
        a(EnumPacketDirection.CLIENTBOUND, PacketPlayOutAbilities.class);
        a(EnumPacketDirection.CLIENTBOUND, PacketPlayOutTabComplete.class);
        a(EnumPacketDirection.CLIENTBOUND, PacketPlayOutScoreboardObjective.class);
        a(EnumPacketDirection.CLIENTBOUND, PacketPlayOutScoreboardScore.class);
        a(EnumPacketDirection.CLIENTBOUND, PacketPlayOutScoreboardDisplayObjective.class);
        a(EnumPacketDirection.CLIENTBOUND, PacketPlayOutScoreboardTeam.class);
        a(EnumPacketDirection.CLIENTBOUND, PacketPlayOutCustomPayload.class);
        a(EnumPacketDirection.CLIENTBOUND, PacketPlayOutKickDisconnect.class);
        a(EnumPacketDirection.CLIENTBOUND, ix.class);
        a(EnumPacketDirection.CLIENTBOUND, ke.class);
        a(EnumPacketDirection.CLIENTBOUND, ku.class);
        a(EnumPacketDirection.CLIENTBOUND, kr.class);
        a(EnumPacketDirection.CLIENTBOUND, lj.class);
        a(EnumPacketDirection.CLIENTBOUND, jn.class);
        a(EnumPacketDirection.CLIENTBOUND, lm.class);
        a(EnumPacketDirection.CLIENTBOUND, ko.class);
        a(EnumPacketDirection.CLIENTBOUND, jl.class);
        a(EnumPacketDirection.SERVERBOUND, PacketPlayInKeepAlive.class);
        a(EnumPacketDirection.SERVERBOUND, PacketPlayInChat.class);
        a(EnumPacketDirection.SERVERBOUND, PacketPlayInUseEntity.class);
        a(EnumPacketDirection.SERVERBOUND, PacketPlayInFlying.class);
        a(EnumPacketDirection.SERVERBOUND, mh.class);
        a(EnumPacketDirection.SERVERBOUND, mj.class);
        a(EnumPacketDirection.SERVERBOUND, mi.class);
        a(EnumPacketDirection.SERVERBOUND, PacketPlayInBlockDig.class);
        a(EnumPacketDirection.SERVERBOUND, PacketPlayInBlockPlace.class);
        a(EnumPacketDirection.SERVERBOUND, PacketPlayInHeldItemSlot.class);
        a(EnumPacketDirection.SERVERBOUND, PacketPlayInArmAnimation.class);
        a(EnumPacketDirection.SERVERBOUND, PacketPlayInEntityAction.class);
        a(EnumPacketDirection.SERVERBOUND, PacketPlayInSteerVehicle.class);
        a(EnumPacketDirection.SERVERBOUND, PacketPlayInCloseWindow.class);
        a(EnumPacketDirection.SERVERBOUND, PacketPlayInWindowClick.class);
        a(EnumPacketDirection.SERVERBOUND, PacketPlayInTransaction.class);
        a(EnumPacketDirection.SERVERBOUND, PacketPlayInSetCreativeSlot.class);
        a(EnumPacketDirection.SERVERBOUND, PacketPlayInEnchantItem.class);
        a(EnumPacketDirection.SERVERBOUND, PacketPlayInUpdateSign.class);
        a(EnumPacketDirection.SERVERBOUND, PacketPlayInAbilities.class);
        a(EnumPacketDirection.SERVERBOUND, PacketPlayInTabComplete.class);
        a(EnumPacketDirection.SERVERBOUND, PacketPlayInSettings.class);
        a(EnumPacketDirection.SERVERBOUND, PacketPlayInClientCommand.class);
        a(EnumPacketDirection.SERVERBOUND, PacketPlayInCustomPayload.class);
        a(EnumPacketDirection.SERVERBOUND, PacketPlayInStopSpectating.class);
        a(EnumPacketDirection.SERVERBOUND, PacketPlayInDownloadResult.class);
    }}, c("STATUS", 2, 1) {{
        a(EnumPacketDirection.SERVERBOUND, nx.class);
        a(EnumPacketDirection.CLIENTBOUND, no.class);
        a(EnumPacketDirection.SERVERBOUND, nw.class);
        a(EnumPacketDirection.CLIENTBOUND, nn.class);
    }}, d("LOGIN", 3, 2) {{
        a(EnumPacketDirection.CLIENTBOUND, ng.class);
        a(EnumPacketDirection.CLIENTBOUND, ne.class);
        a(EnumPacketDirection.CLIENTBOUND, nd.class);
        a(EnumPacketDirection.CLIENTBOUND, nf.class);
        a(EnumPacketDirection.SERVERBOUND, ni.class);
        a(EnumPacketDirection.SERVERBOUND, nj.class);   
    }};
    private static final TIntObjectMap e = new TIntObjectHashMap();
    private static final Map f = Maps.newHashMap();
    private final int g;
    private final Map h;
    // $FF: synthetic field
    private static final gy[] i = new gy[] { a, b, c, d };

    private gy(String var1, int var2, int var3) {
        this.h = Maps.newEnumMap(EnumPacketDirection.class);
        this.g = var3;
    }

    protected gy a(EnumPacketDirection var1, Class var2) {
        Object var3 = (BiMap) this.h.get(var1);
        if (var3 == null) {
            var3 = HashBiMap.create();
            this.h.put(var1, var3);
        }

        if (((BiMap) var3).containsValue(var2)) {
            String var4 = var1 + " packet " + var2 + " is already known to ID " + ((BiMap) var3).inverse().get(var2);
            LogManager.getLogger().fatal(var4);
            throw new IllegalArgumentException(var4);
        } else {
            ((BiMap) var3).put(Integer.valueOf(((BiMap) var3).size()), var2);
            return this;
        }
    }

    public Integer a(EnumPacketDirection var1, Packet var2) {
        return (Integer) ((BiMap) this.h.get(var1)).inverse().get(var2.getClass());
    }

    public Packet a(EnumPacketDirection var1, int var2) throws InstantiationException, IllegalAccessException {
        Class var3 = (Class) ((BiMap) this.h.get(var1)).get(Integer.valueOf(var2));
        return var3 == null ? null : (Packet) var3.newInstance();
    }

    public int a() {
        return this.g;
    }

    public static gy a(int var0) {
        return (gy) e.get(var0);
    }

    public static gy a(Packet var0) {
        return (gy) f.get(var0.getClass());
    }

    // $FF: synthetic method
    gy(String var1, int var2, int var3, gz var4) {
        this(var1, var2, var3);
    }

    static {
        gy[] var0 = values();
        int var1 = var0.length;

        for (int var2 = 0; var2 < var1; ++var2) {
            gy var3 = var0[var2];
            e.put(var3.a(), var3);
            Iterator var4 = var3.h.keySet().iterator();

            while (var4.hasNext()) {
                EnumPacketDirection var5 = (EnumPacketDirection) var4.next();

                Class var7;
                for (Iterator var6 = ((BiMap) var3.h.get(var5)).values().iterator(); var6.hasNext(); f.put(var7, var3)) {
                    var7 = (Class) var6.next();
                    if (f.containsKey(var7) && f.get(var7) != var3) {
                        throw new Error("Packet " + var7 + " is already assigned to protocol " + f.get(var7) + " - can\'t reassign to " + var3);
                    }

                    try {
                        var7.newInstance();
                    } catch (Throwable var9) {
                        throw new Error("Packet " + var7 + " fails instantiation checks! " + var7);
                    }
                }
            }
        }

    }
}
