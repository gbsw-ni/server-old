variable "vpc_name" {
  type        = string
  description = "The name tag for the VPC"
}

variable "cidr_block" {
  type        = string
  description = "The CIDR block for the VPC"
}

variable "vpc_id" {
  type        = string
  description = "The VPC ID this subnet belongs to"
}


# --- 


variable "subnet" {
  type = list(object({
    cidr_block        = string
    availability_zone = string
    name              = string
  }))
  description = "List of subnets to create"
}


# ---


variable "rtb" {
  type = list(object({
    name       = string
    gateway_id = string  // IGW for Public, NAT GW for Private
  }))
  description = "List of route tables to create, including their names and gateway IDs"
}


# ---


variable "igw" {
  type        = string
  description = "The name tag for the Internet Gateway"
}


# ---


variable "nat" {
  type = list(object({
    subnet_id = string
    name      = string
  }))
  description = "List of NAT Gateways to create"
}


# ---


variable "asso" {
  type = list(object({
    subnet_id      = string
    route_table_id = string
  }))
  description = "List of associations between subnets and route tables"
}
