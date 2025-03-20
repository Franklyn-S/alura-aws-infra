package com.myorg;

import software.amazon.awscdk.App;

public class AluraAwsInfraApp {
    public static void main(final String[] args) {
        App app = new App();
        var aluraVPCStack = new AluraVPCStack(app, "vpc");
        var clusterStack = new AluraClusterStack(app, "cluster", aluraVPCStack.getVpc());
        clusterStack.addDependency(aluraVPCStack);
        AluraServiceStack aluraServiceStack = new AluraServiceStack(app, "service", clusterStack.getCluster());
        aluraServiceStack.addDependency(clusterStack);
        app.synth();
    }
}

