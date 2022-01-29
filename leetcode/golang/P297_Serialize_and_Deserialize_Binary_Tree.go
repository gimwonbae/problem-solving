import "strconv"

type Codec struct {
    root *TreeNode
    input []string
}

func Constructor() Codec {
    x := Codec{root: nil, input: []string{}}
    return x
}

// Serializes a tree to a single string.
func (this *Codec) serialize(root *TreeNode) string {
    return this.serialize_helper(root, "")    
}
// Builds up the string
func (this *Codec) serialize_helper(root *TreeNode, res string) string {
    if root == nil {
        return res + "null,"
    } else {
        res += strconv.Itoa(root.Val) + ","
        res = this.serialize_helper(root.Left, res)
        res = this.serialize_helper(root.Right, res)
    }
    return res
}

// Deserializes your encoded data to tree.
func (this *Codec) deserialize(data string) *TreeNode {    
    this.input = strings.Split(data, ",")
    return this.deserialize_helper()
}

func (this *Codec) deserialize_helper() *TreeNode {
    if this.input[0] == "null" {
        this.input = this.input[1:]
        return nil
    }
    val, _ := strconv.Atoi(this.input[0])
    this.input = this.input[1:]
    x := TreeNode{Val: val, Left: nil, Right: nil}
    x.Left = this.deserialize_helper()
    x.Right = this.deserialize_helper()
    return &x
}
