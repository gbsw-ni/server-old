module "vpc" {
  source = "./modules/vpc/vpc"

  vpc_name   = "ni-vpc"
  cidr_block = "10.0.0.0/16"
}


# ---


module "subnet" {
  source     = "./modules/vpc/subnet"
  vpc_id     = module.vpc.vpc_id

  subnets = [
    {
      name       = "Public Subnet A"
      cidr       = "10.0.0.0/24"
      az         = "ap-northeast-2a"
      is_public  = true
    },
    {
      name       = "Public Subnet B"
      cidr       = "10.0.1.0/24"
      az         = "ap-northeast-2b"
      is_public  = true
    },
    {
      name       = "Private Subnet A"
      cidr       = "10.0.2.0/24"
      az         = "ap-northeast-2a"
      is_public  = false
    },
    {
      name       = "Private Subnet B"
      cidr       = "10.0.3.0/24"
      az         = "ap-northeast-2b"
      is_public  = false
    }
  ]
}


# ---


module "route_table" {
  source  = "./modules/vpc/rtb"
  vpc_id  = module.vpc.vpc_id

  public_route_table = {
    name = "ni-public-rtb"
  }

  private_route_tables = [
    {
      name = "ni-private-a-rtb"
      az   = "ap-northeast-2a"
    },
    {
      name = "ni-private-b-rtb"
      az   = "ap-northeast-2b"
    }
  ]
}


# ---


module "natgw" {
  source       = "./modules/vpc/nat"
  nat_gateways = [
    {
      name      = "ni-nat-a"
      subnet_id = module.subnet.subnets[2].id  # private subnet a
    },
    {
      name      = "ni-nat-b"
      subnet_id = module.subnet.subnets[3].id  # private subnet b
    }
  ]
}


# ---


module "route_table_association" {
  source       = "./modules/vpc/rta"
  associations = [
    { # public subnet a
      subnet_id      = module.subnet.subnets[0].id  
      route_table_id = module.route_table.public_route_table_id
    },
    { # public subnet b
      subnet_id      = module.subnet.subnets[1].id  
      route_table_id = module.route_table.public_route_table_id
    },
    { # private subnet a
      subnet_id      = module.subnet.subnets[2].id  
      route_table_id = module.route_table.private_route_tables[0].id
    },
    { # private subnet b
      subnet_id      = module.subnet.subnets[3].id  
      route_table_id = module.route_table.private_route_tables[1].id
    }
  ]
}
