package de.themoep.idconverter;

import java.util.Map;

public class Util
{
    public static final String INTERNAL_DELIMITER = ":";

    public static void populateMaps(IdMappings.Mapping[] mappings, Map<String, IdMappings.Mapping> numeric,
                                    Map<String, IdMappings.Mapping> legacy, Map<String, IdMappings.Mapping> flattening)
    {
        for (IdMappings.Mapping mapping : mappings) {
            if (mapping.getNumericId() >= 0) {
                numeric.put(mapping.getNumericId() + INTERNAL_DELIMITER + mapping.getData(), mapping);
                if (mapping.getData() == 0) {
                    numeric.put(String.valueOf(mapping.getNumericId()), mapping);
                }
            }
            if (mapping.getLegacyType() != null) {
                legacy.put(mapping.getLegacyType() + INTERNAL_DELIMITER + mapping.getData(), mapping);
                if (mapping.getData() == 0) {
                    legacy.put(mapping.getLegacyType(), mapping);
                }
            }
            if (mapping.getFlatteningType() != null) {
                flattening.put(mapping.getFlatteningType(), mapping);
            }
        }
    }
}
