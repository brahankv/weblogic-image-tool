// Copyright (c) 2020, 2021, Oracle and/or its affiliates.
// Licensed under the Universal Permissive License v 1.0 as shown at https://oss.oracle.com/licenses/upl.

package com.oracle.weblogic.imagetool.tests.utils;

import java.nio.file.Path;
import java.util.Arrays;
import java.util.stream.Collectors;

public class CreateMIIImageCommand extends ImageToolCommand {
    private String version;
    private String type;

    private String jdkVersion;
    private String fromImage;
    private String tag;
    private String additionalBuildCommands;

    // WDT flags
    private String wdtVersion;
    private String wdtModel;
    private String wdtArchive;
    private String wdtVariables;
    private String wdtModelHome;

    public CreateMIIImageCommand() {
        super("create_mii_image");
    }

    public CreateMIIImageCommand version(String value) {
        version = value;
        return this;
    }

    public CreateMIIImageCommand jdkVersion(String value) {
        jdkVersion = value;
        return this;
    }

    public CreateMIIImageCommand fromImage(String value) {
        fromImage = value;
        return this;
    }

    public CreateMIIImageCommand fromImage(String name, String version) {
        return fromImage(name + ":" + version);
    }

    public CreateMIIImageCommand tag(String value) {
        tag = value;
        return this;
    }
    
    public CreateMIIImageCommand additionalBuildCommands(Path value) {
        additionalBuildCommands = value.toString();
        return this;
    }

    public CreateMIIImageCommand wdtVersion(String value) {
        wdtVersion = value;
        return this;
    }

    public CreateMIIImageCommand wdtModel(Path... values) {
        wdtModel = Arrays.stream(values).map(Path::toString).collect(Collectors.joining(","));
        return this;
    }

    public CreateMIIImageCommand wdtArchive(Path value) {
        wdtArchive = value.toString();
        return this;
    }

    public CreateMIIImageCommand wdtVariables(Path value) {
        wdtVariables = value.toString();
        return this;
    }

    public CreateMIIImageCommand wdtModelHome(String value) {
        wdtModelHome = value;
        return this;
    }

    /**
     * Generate the command using the provided command line options.
     * @return the imagetool command as a string suitable for running in ProcessBuilder
     */
    public String build() {
        return super.build()
            + field("--version", version)
            + field("--jdkVersion", jdkVersion)
            + field("--fromImage", fromImage)
            + field("--tag", tag)
            + field("--type", type)
            + field("--additionalBuildCommands", additionalBuildCommands)
            + field("--wdtVersion", wdtVersion)
            + field("--wdtModel", wdtModel)
            + field("--wdtArchive", wdtArchive)
            + field("--wdtVariables", wdtVariables)
            + field("--wdtModelHome", wdtModelHome);
    }
}
