package com.myorg;

import software.amazon.awscdk.Stack;
import software.amazon.awscdk.StackProps;
import software.amazon.awscdk.services.ec2.*;
import software.amazon.awscdk.services.ecs.*;
import software.amazon.awscdk.services.ecs.patterns.*;
import software.constructs.Construct;


public class AluraClusterStack extends Stack {
    private Cluster cluster;

    public AluraClusterStack(final Construct scope, final String id, final Vpc vpc) {
        this(scope, id, null, vpc);
    }

    public AluraClusterStack(final Construct scope, final String id, final StackProps props, final Vpc vpc  ) {
        super(scope, id, props);


        this.cluster = Cluster.Builder.create(this, "AluraCluster")
                .clusterName("cluster-alura")
                .vpc(vpc).build();

    }

    public Cluster getCluster(){
        return cluster;
    }
}
