package com.myorg;

import software.amazon.awscdk.Stack;
import software.amazon.awscdk.StackProps;
import software.constructs.Construct;
import software.amazon.awscdk.services.ec2.*;
import software.amazon.awscdk.services.ecs.*;
import software.amazon.awscdk.services.ecs.patterns.*;


public class AluraVPCStack extends Stack {

    private Vpc vpc;

    public AluraVPCStack(final Construct scope, final String id) {
        this(scope, id, null);
    }

    public AluraVPCStack(final Construct scope, final String id, final StackProps props) {
        super(scope, id, props);

        this.vpc = Vpc.Builder.create(this, "AluraVpc")
                .maxAzs(3)  // Default is all AZs in region
                .build();

    }

    public Vpc getVpc() {
        return vpc;
    }
}
