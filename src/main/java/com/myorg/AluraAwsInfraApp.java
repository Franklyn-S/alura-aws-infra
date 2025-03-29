package com.myorg;

import software.amazon.awscdk.App;

// cdk deploy --parameters Rds:senha=12345678 Rds
public class AluraAwsInfraApp {
    public static void main(final String[] args) {
        App app = new App();
        var aluraVPCStack = new AluraVPCStack(app, "vpc");
        var clusterStack = new AluraClusterStack(app, "cluster", aluraVPCStack.getVpc());
        clusterStack.addDependency(aluraVPCStack);

        AluraRdsStack rdsStack = new AluraRdsStack(app, "Rds", aluraVPCStack.getVpc());
        rdsStack.addDependency(aluraVPCStack);

        AluraServiceStack aluraServiceStack = new AluraServiceStack(app, "service", clusterStack.getCluster());
        aluraServiceStack.addDependency(clusterStack);
        aluraServiceStack.addDependency(rdsStack);
        app.synth();
    }
}

