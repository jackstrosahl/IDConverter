package de.themoep.idconverter;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class EnchantmentIdMappings
{
    public static final IdMappings.Mapping[] MAPPINGS = {
        new IdMappings.Mapping(0, "protection"),
        new IdMappings.Mapping(1, "fire_protection"),
        new IdMappings.Mapping(2, "feather_falling"),
        new IdMappings.Mapping(3, "blast_protection"),
        new IdMappings.Mapping(4, "projectile_protection"),
        new IdMappings.Mapping(5, "respiration"),
        new IdMappings.Mapping(6, "aqua_affinity"),
        new IdMappings.Mapping(7, "thorns"),
        new IdMappings.Mapping(8, "depth_strider"),
        new IdMappings.Mapping(9, "frost_walker"),
        new IdMappings.Mapping(10, "binding_curse"),
        new IdMappings.Mapping(16, "sharpness"),
        new IdMappings.Mapping(17, "smite"),
        new IdMappings.Mapping(18, "bane_of_arthropods"),
        new IdMappings.Mapping(19, "knockback"),
        new IdMappings.Mapping(20, "fire_aspect"),
        new IdMappings.Mapping(21, "looting"),
        new IdMappings.Mapping(22, "sweeping"),
        new IdMappings.Mapping(32, "efficiency"),
        new IdMappings.Mapping(33, "silk_touch"),
        new IdMappings.Mapping(34, "unbreaking"),
        new IdMappings.Mapping(35, "fortune"),
        new IdMappings.Mapping(48, "power"),
        new IdMappings.Mapping(49, "punch"),
        new IdMappings.Mapping(50, "flame"),
        new IdMappings.Mapping(51, "infinity"),
        new IdMappings.Mapping(61, "luck_of_the_sea"),
        new IdMappings.Mapping(62, "lure"),
        new IdMappings.Mapping(65, "loyalty"),
        new IdMappings.Mapping(66, "impaling"),
        new IdMappings.Mapping(67, "riptide"),
        new IdMappings.Mapping(68, "channeling"),
        new IdMappings.Mapping(70, "mending"),
        new IdMappings.Mapping(71, "vanishing_curse"),
    };

    private final static Map<String, IdMappings.Mapping> BY_NUMERIC_ID = new HashMap<>();
    private final static Map<String, IdMappings.Mapping> BY_LEGACY_NAME = new HashMap<>();
    private final static Map<String, IdMappings.Mapping> BY_FLATTENING_NAME = new HashMap<>();

    static {
        Util.populateMaps(MAPPINGS, BY_NUMERIC_ID, BY_LEGACY_NAME, BY_FLATTENING_NAME);
    }

    public static IdMappings.Mapping get(IdMappings.IdType type, String id) {
        switch (type) {
            case NUMERIC:
                return getById(id);
            case LEGACY:
                return getByLegacyType(id);
            case FLATTENING:
                return getByFlatteningType(id);
            default:
                throw new IllegalArgumentException(type + " is not a valid map type.");
        }
    }

    public static IdMappings.Mapping getById(String id) {
        return BY_NUMERIC_ID.get(id.toUpperCase(Locale.ENGLISH));
    }

    public static IdMappings.Mapping getByLegacyType(String oldType) {
        return BY_LEGACY_NAME.get(oldType.toUpperCase(Locale.ENGLISH));
    }

    public static IdMappings.Mapping getByFlatteningType(String flatteningType) {
        return BY_FLATTENING_NAME.get(flatteningType.toUpperCase(Locale.ENGLISH));
    }
}
